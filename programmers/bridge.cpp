#include <string>
#include <vector>
using namespace std;

class Truck
{
    public:
    int weight;
    int position;
};

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int truck_weight_on_bridge = 0;
    vector<Truck> bridge_truck;
    while(true)
    {
        if(bridge_truck.empty() && truck_weights.empty())
        {
            break;
        }

        for(int i=0;i<bridge_truck.size();++i)
        {
            ++bridge_truck[i].position;
        }

        if(!bridge_truck.empty() && bridge_length < bridge_truck.front().position)
        {
            truck_weight_on_bridge -= bridge_truck.front().weight;
            bridge_truck.erase(bridge_truck.begin());
        }

        if(!truck_weights.empty() && truck_weight_on_bridge + truck_weights[0] <= weight)
        {
            truck_weight_on_bridge += truck_weights[0];
            Truck truck;
            truck.position = 1;
            truck.weight = truck_weights[0];
            bridge_truck.push_back(truck);
            truck_weights.erase(truck_weights.begin());
        }
        
        ++answer;
    }
    return answer;
}