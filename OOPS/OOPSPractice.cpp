#include <bits/stdc++.h>
#include<iostream>
//alreAdy includes iostream, string and all required headers
//this is available in g++
//have to run it in c++11, starting with overloaded paramter constructors.
using namespace std;

//Protected specifier is available to class and sub-class, but not outside that.
//by default access specifier is Private.

class Human
{
private:
	int age;
	string name="noname";

protected:
	int height;
	string sname;

public:
	
	//Default Constructor, fn naqme should be same as class name.
	Human(){
		age=0;
		count++;
		cout<<"Constructor is called when a human object is created"<<endl;
	}
	//Overloading constructor with the parameters.
	Human(int age, string s){
		this->age=age; //using "this" pointer.
		name=s;
		count++;
		cout<<"Values are initialised"<<endl;
	}
	
	//incase Default Constructor is not there, we can add defaulkt values to the parameter
	//which can be overwrite later.
	// Human(int n=0, string s="noname"){

	//static variable, storedin the heap, for all-access
	static int count;

	void humanTotal(){
		cout<<"Total number of people are: "<<count<<endl;
	}
	//static member function only uses static member variables.
	static void humantotal(){
		cout<<"Total number of people are: "<<count<<endl;
	}

	void introduce();
	
	//virtual rule brings polymorphism in the member
	//this means execution of the code is dependant on the basis of class
	//which invoked the given function.
	virtual void dA(){
		cout<<age<<" "<<name<<endl;
	}
	//It has heirachial nature, also once given virtual parameter
	//It will always be virtual for the 
	//class inherited from class... inherited from this class
	
	void sA(int s){
		age=s;
	}
	void sh(int i){height=i;}
	void ssn(string p){sname=p;}

	//friend function,
	// it allows access to private members outside this function as well.
	friend void display(Human man);
	//For making a another class, friend to this class
	//friend class #class_name#

	//Nested Class
	class Address{
	public:
		string country;
		string city;
		int hno;
	};
	Address adr;
	void sAdr(){
		cout<<name<<", "<<adr.country<<", "<<adr.city<<", "<<adr.hno<<endl;
	}

	//Destructor made
	~Human(){
		//We can dynamically deallocate the memory by using the delte function
		//If you are using the initializing pointer to the data-types.
		cout<<"Destructor called"<<endl;
	}

};

/*
Pure Virtual: (virtual void_similar function_name(parameter(s))=0;)
can be defined outside the class using Scope Resolution Operator
It has to overriden by some (also atleast one) derived class(es).

Abstract Class: Class with one or more pure virtual functions.
It's of no use. No objects can be created of this class.
Unless a sub-class inherited from this class is being made which also 
	overrides all the pure virtual functions.
*/

/*
---------------------------------------------------------------
| members in  |Inheritance mode(then members in derived class)|
| base class  | Public   |   Protected   |   Private          |
---------------------------------------------------------------
| Public      | Public   |  Protected    |   Private          |
| Protected   | Protected|  Protected    |   Private          |
| Private     |  X       |     X         |  X={Not Available} |
---------------------------------------------------------------
//Inheritannce from base class (->Human, in this case)
//Since student(derived class/ sub-class) is also a person
//Again, Default inheritance access specifier is also private.*/

class Student : public Human{
public:

	Human :: height; //access declaration, change the sope or access level
	// of any member.
	//classname :: functionName; 
	//for the function access change, not with "()"
	// not for private member of base class, as it is not accessible here.

	int id;

	Student(){
		cout<<"Constructor for Stduent class (a sub-class inherited form Human class) is called."<<endl;
	}
	Student(int i) : Human(){
		id=i;
		cout<<"Student constructor with parameter is called"<<endl;
	}
	Student(int i, string s, int n) : Human(n,s){
		id=i;
		cout<<"Stu Constr with constr parameters of Base class is called"<<endl;
	}
	//For multiple Inheritance case:
	//SubClassConstr(paras): Bc1(some or bo para),.., Bcn(some or no para){}
	//Bc1==Any of the Base-Class Constructor
	
	~Student(){
		cout<<"Destructor for Student class is called"<<endl;
	}
	//Overriding Base Class Methods in Derived Class
	void dA(){
		cout<<"Overriden dA method:"<<id<<" "<<height<<endl;
		// cout<<age<<" "<<name<<endl; similar prob as intro() member.
	}
	void setid(int id){this->id=id;} 
	//using "this" pointer
	void intro(){
		// cout<<age<<" "<<name<<" and:"<<id<<endl;
		cout<<height<<" "<<sname<<" and:"<<id<<endl;
	}
	//As per table age, name can't be accessed.
	//But height and sname(school) can be accessed.
};

//Multiple Inheritance
//class subname : as1 cn1, as2 cn2, ..... , asn csn{};
//as== access specifier, cn== base class name, 
//n== number of classes from which inherited from.

//New classes for example of polymorphism.
class Farmer : public Human{
public:
	void dA(){
		cout<<"hey from Farmer";
	}
};
class Teacher : public Human{
public:
};

//Not a member of the class:
void display(Human man){
	cout<<"Via: friend function-> "<<man.age<<" also his name: "<<man.name<<endl;
}

//declaration of the static variable, before running the actual code
//otherwise it will start from some garbage value
int Human::count=0;

//This won't work;
// Human::name="noname";

//Scope Resolution Operator
//(To check if it works for public and protected member as well or not)
void Human::introduce(){
	cout<<Human::name<<endl;
}


//DIAMOND PROBLEM
class Animal{
public:
	Animal(){
		cout<<"Animal constyr"<<endl;
	}
	int age;
	void walk(){cout<<"animal walks"<<endl;}
};
//use of "virtual" keyword here, so that no problem occurs.
// hence will have constructor inheritance heirachy calling.
class Tiger: virtual public Animal{
public:
	Tiger(){
		cout<<"Tiger constyr"<<endl;
	}
};
class Lion: virtual public Animal{
public:
	Lion(){
		cout<<"Lion constyr"<<endl;
	}
};
//Good practice to use "virtual" keyword when
//derived class is used as base class for some other class.
class Liger: public Tiger, public Lion{
public:
	Liger(){
		cout<<"Liger constyr"<<endl;
	}
};
//Constructors calling:
//Without "virtual" keyword: Animal constyr Tiger constyr Animal constyr Lion constyr Liger constyr
//With "virtual" keyword: Animal constyr Tiger constyr Lion constyr Liger constyr

void BoyList();

int main(int argc, char const *argv[])
{
	cout<<Human::count<<endl;
	
	Human h(25, "hero");

	//static variable function are called by scope resolution operator
	Human::humantotal();
	
	Human *x = new Human;
	
	h.introduce();
	display(h);
	
	x->introduce();
	x->adr.country="India";
	(*x).adr.city="Satna";
	x->adr.hno=400;
	x->sAdr();
	delete x;
	//Creating object of Nested Class using SRO.
	Human::Address adr;
	
	h.sA(24);
	h.dA();
	h.humanTotal();
	
	Student s; // similar to Human s..
	s.ssn("MVALH");
	s.sh(25);s.dA();
	s.setid(102040);
	s.intro();
	cout<<s.height<<endl;

	Student p(256);
	p.ssn("Halla");p.sh(101);
	p.intro();

	Student ab(255, "jaiShreeRam", 40);
	display(ab); //as Stduent ab === Human ab (due to inheritance);
	ab.intro();
	ab.introduce();
	ab.dA();
	ab.Human::dA(); 
	//Accessing overriden base class method(using ScopeResolution Operator)
	
	//Example for polymorphism.
	Farmer far;
	Teacher tea;
	far.dA(); //It will be overriuden by the dA function member in farmer class.
	tea.dA();  //It will not be overriden as there is no such member in the class.

	cout<<Human::count<<endl;

	Liger lig;
	lig.walk();

	BoyList();
	// Boy ss; class can't be accessed outside the function

	return 0;
}

//Creation of Local Classes
void BoyList(){
	class Boy{
	public:
		int age;
		string name;

		void display(){
			cout<<name<<" "<<age<<endl;
		}
	};
	Boy A10[5];
	for (int i = 0; i < 5; ++i)
	{
		A10[i].age=i+1;
		A10[i].name='a'+i+5;
	}
	for (int i = 0; i < 3; ++i)
	{
		A10[i].display();
	}
}
