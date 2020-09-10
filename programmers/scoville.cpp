#include <string>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX_ELEMENT 1000001 // 힙 안에 저장된 요소의 개수

typedef struct{
  int heap[MAX_ELEMENT];
  int heap_size;
} HeapType;



void insert_min_heap(HeapType *h, int item){
  int i;
  i = ++(h->heap_size); // 힙 크기를 하나 증가

  /* 트리를 거슬러 올라가면서 부모 노드와 비교하는 과정 */
  // i가 루트 노트(index: 1)이 아니고, 삽입할 item의 값이 i의 부모 노드(index: i/2)보다 크면
  while((i != 1) && (item < h->heap[i/2])){
    // i번째 노드와 부모 노드를 교환환다.
    h->heap[i] = h->heap[i/2];
    // 한 레벨 위로 올라단다.
    i /= 2;
  }
  h->heap[i] = item; // 새로운 노드를 삽입
}

int delete_min_heap(HeapType *h){
  int parent, child;
  int item, temp;

  item = h->heap[1]; // 루트 노드 값을 반환하기 위해 item에 할당
  temp = h->heap[(h->heap_size)--]; // 마지막 노드를 temp에 할당하고 힙 크기를 하나 감소
  parent = 1;
  child = 2;

  while(child <= h->heap_size){
    // 현재 노드의 자식 노드 중 더 큰 자식 노드를 찾는다. (루트 노드의 왼쪽 자식 노드(index: 2)부터 비교 시작)
    if( (child < h->heap_size) && ((h->heap[child]) > h->heap[child+1]) ){
      child++;
    }
    // 더 큰 자식 노드보다 마지막 노드가 크면, while문 중지
    if( temp <= h->heap[child] ){
      break;
    }

    // 더 큰 자식 노드보다 마지막 노드가 작으면, 부모 노드와 더 큰 자식 노드를 교환
    h->heap[parent] = h->heap[child];
    // 한 단계 아래로 이동
    parent = child;
    child *= 2;
  }

  // 마지막 노드를 재구성한 위치에 삽입
  h->heap[parent] = temp;
  // 최댓값(루트 노드 값)을 반환
  return item;
}

int make_scovile(int a,int b)
{
    return a + (b * 2);
}

int solution(vector<int> scoville, int K) {
    int answer = 0;
    HeapType scoville_heap;
    scoville_heap.heap_size = 0;
    for(int i=0;i < scoville.size();++i)
    {
        insert_min_heap(&scoville_heap,scoville[i]);
    }

    while(true)
    {
        if(K <= scoville_heap.heap[1]) break;
        if(scoville_heap.heap_size == 1)
        {
            answer = -1;
            break;
        }
        int scoville_one = delete_min_heap(&scoville_heap);
        int scoville_two = delete_min_heap(&scoville_heap);
        int mix_scoville = make_scovile(scoville_one, scoville_two);

        insert_min_heap(&scoville_heap, mix_scoville);

        ++answer;
    }

    return answer;
}