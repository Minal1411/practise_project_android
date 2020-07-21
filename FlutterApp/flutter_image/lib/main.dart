import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: NavigationDrawer(),
    );
  }
}
class NavigationDrawer extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Container(
      child: Scaffold(
        appBar: AppBar(
          title: Text('Navigation Drawer'),
        ),
        drawer: Drawer(
          child: ListView(
            padding: EdgeInsets.zero,
            children: <Widget>[
              UserAccountsDrawerHeader(
                currentAccountPicture: CircleAvatar(
                  backgroundImage: AssetImage("assest/images/people.png",w),

                ),
              accountName: Text("Arsal Ali"),
              accountEmail: Text("k.minal93@gmail.com")
          ),
              ListTile(
                leading: Icon(Icons.accessible),
                title: Text('Item1'),
                onTap: (){
                  Navigator.pop(context);
                  
                },
              )
            ],
          ),
        ),
      ),
    );
  }
  
}
