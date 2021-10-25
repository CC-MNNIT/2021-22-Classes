import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: const Center(
        child: Text('Hello, World!',
        textDirection: TextDirection.ltr,
        style: TextStyle(color: Colors.black, fontSize: 30),)
      ),
      decoration: const BoxDecoration(color: Colors.white),
    );
  }
}
