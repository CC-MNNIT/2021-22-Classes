import 'package:flutter/material.dart';
import 'package:stateful_sample/stateful_sample.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Stateful Sample',
      home: StatefulSample(),
      debugShowCheckedModeBanner: false,
    );
  }
}