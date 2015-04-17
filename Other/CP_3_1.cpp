#include <iostream>
#include <cstddef>
#include <cstring>

using namespace std;

inline bool isHandle(string &first,string &second){
	string str = first+first;
	char ch = strstr(str.c_str(),second.c_str());

	return (idx  != string::npos) ? true : false;
}

int main(){

	string first("ABCD"),second("CDAB");

	bool res = isHandle(first,second);

	cout<<res<<endl;

	return 0;
}