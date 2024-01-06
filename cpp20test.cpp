#include <span>
#include <vector>
#include <iostream>

int main() {
    std::vector<int> numbers = {1, 2, 3, 4, 5};

    // 使用范围基于的 for 循环
    for (int num : numbers) {
        std::cout << num << " ";
    }

    for (int num : {1,2,3,4}) {
        std::cout << num << "hello" << std::endl;
    }
 
    return 0;
}
