import 'package:flutter/material.dart';
import 'package:pob_m/ChildPageStateWidget.dart';

// homepage stateful
class HomePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _HomeState();
  }
}

//homepage state
class _HomeState extends State<HomePage> {

  // set the original state
  int _currentIndex = 0;

  // a list of all the states of the navigation bar
  final List<Widget>_children = [
    ChildStateWidget(Colors.blue),
    ChildStateWidget(Colors.yellow),
    ChildStateWidget(Colors.red),
    ChildStateWidget(Colors.green),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body:_children[_currentIndex],

      bottomNavigationBar: new Theme(
        data: Theme.of(context).copyWith(
          //color of the navigation bar
          canvasColor: Colors.blue,
          //color of the navigation bar when tapped
          primaryColor:Colors.lightBlueAccent,
           // color of inactive?
            textTheme: Theme
                .of(context)
                .textTheme
                .copyWith(caption: new TextStyle(color: Colors.white))
      ),
        child: new BottomNavigationBar(
          type: BottomNavigationBarType.fixed,
          onTap: onTabTapped,  // set the index of the current tab
          currentIndex: _currentIndex, // this will be set when a new tab is tapped
        items: [
          BottomNavigationBarItem(
            icon: new Icon(Icons.home),
            title: new Text('天赋'),
          ),
          BottomNavigationBarItem(
            icon: new Icon(Icons.mail),
            title: new Text('装备'),
          ),
          BottomNavigationBarItem(
              icon: Icon(Icons.person),
              title: Text('技能')
          ),
          BottomNavigationBarItem(
              icon:Icon(Icons.ac_unit),
              title:Text('计算')
          )
        ],
      ),
    ),
    );
  }

  void onTabTapped(int index) {
    setState((){
      _currentIndex = index;
    });
  }

}



