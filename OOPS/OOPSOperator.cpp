#include<bits/stdc++.h>
#include<iostream>
using namespace std;

/*
To look at
Struct.. basic, with constructor/deconstructors and functions.
Enum.. traversal, fields, constructors and methods..
*/
class Marks
{
	int intmark,extmark;
public:
	Marks(){
		intmark=extmark=0; //default way to get into private mode.
	}
	Marks(int in, int en){
		intmark=in;
		extmark=en;
	}

	void display(){
		cout<<intmark<<" "<<extmark<<endl;
	}

	//Operator Overloading function
	Marks operator+(Marks m){
		Marks temp;
		temp.intmark=intmark+m.intmark;
		temp.extmark=extmark+m.extmark;
		return temp;
	}

	Marks operator-(Marks m);

	//This function takes exactly one argument
	void operator+=(Marks m){
		intmark+=m.intmark;
		extmark+=m.extmark;
	}

	// This one takes two arguments, one for referncing object and other for value change
	friend void operator-=(Marks curr, Marks m);
	friend void operator-=(Marks curr, int m);

	//unary ascending and descending operators for PREFIX FORM
	void operator++(){
		intmark+=1;
	}
	friend Marks operator--(Marks&);

	//unary ascending and descending operators for POSTFIX FORM
	//here (parameter=int) specifies that it is in postfix form..
	Marks operator++(int){
		Marks duplicate(*this);
		intmark+=1; // (2) but actual one is being affected..
		return duplicate; // (1) old one being returned
	}
	// friend Marks operator--(Marks&,int); 
	//intialization for POSTFIX -- (unary operator) friend class object returning function

};

//Operator Overloading '-' operator using SRO
// Different than Marks :: Marks operator-(Marks m)
//as we did for Human:: void introduce(){ .....; } 
Marks Marks :: operator-(Marks m){
	Marks temp;
		temp.intmark=intmark-m.intmark;
		temp.extmark=extmark-m.extmark;
		return temp;
}

void operator-=(Marks curr, Marks m){
	curr.intmark-=m.intmark;
	curr.extmark-=m.extmark;
}
void operator-=(Marks curr, int m){
	curr.intmark-=m;
}

Marks operator--(Marks &m){
	m.extmark-=1;
	return m;
}

int main(){
	Marks m1(10,20), m2(30,20);
	Marks m3=m2+m1, m4=m2-m1;
	// Marks m2+=m1 or m2=m2+m1 is not possible.
	// For those, we have to genrate operator overloadings for "+=/-=" as well.
	m3.display();
	m4.display();
	m4+=m2; m4.display();
	m3-=m1; m3.display();
	m4-=20; m4.display();
	
	//difference in returning void and class object function(S).
	++m4;
	m4.display();
	(--m4).display();

	(m4++).display();
	m4.display();

	return 0;
}
