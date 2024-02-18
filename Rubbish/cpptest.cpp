#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

class cpptest {
private:
    void func(void);

public:
    int name;
    cpptest(int v);
    ~cpptest();
};

void cpptest::func(void) {
}

cpptest::cpptest(int v) {
    this->name = v;
}

cpptest::~cpptest() {
}

int main(int argc, char const* argv[]) {
    cout << "hello\n";
    cpptest* cp = new cpptest(3);
    cout << cp->name << std::endl;
    printf("%p\n", cp);
    delete cp;
    cp->name = 30;
    printf("%p\n", cp);
    printf("%d\n", sizeof(cp));
    return 0;
}
