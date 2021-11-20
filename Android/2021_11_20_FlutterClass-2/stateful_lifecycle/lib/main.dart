import 'package:flutter/material.dart';
import 'package:screen_lifecycle/life_cycle.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'LifeCycle',
      home: LifeCycle(),
      debugShowCheckedModeBanner: false,
    );
  }
}