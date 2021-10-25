import 'package:flutter/material.dart';

class StatefulSample extends StatefulWidget {
  const StatefulSample({Key? key}) : super(key: key);

  //createState(): When the Framework is instructed to build a StatefulWidget, it immediately calls createState()
  @override
  State<StatefulWidget> createState() {
    return StatefulSampleState();
  }
}

class StatefulSampleState extends State<StatefulSample> {
  int count = 0;
  /*
    build(): This method is called often. It is required, and it must return a Widget.
    */
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("AppBar"),
      ),
      body: Center(
        child: MaterialButton(
          child: Text(
            "Click me",
            style: TextStyle(
                fontSize: 50,
                color: (((count % 2) == 0) ? Colors.orange : Colors.blue)),
          ),
          onPressed: changeSomething,
        ),
      ),
    );
  }

  void changeSomething() {
    setState(() {
      count++;
    });
  }
}
