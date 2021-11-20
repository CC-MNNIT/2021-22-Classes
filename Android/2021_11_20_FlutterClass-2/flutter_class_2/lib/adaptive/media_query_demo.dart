import 'package:flutter/material.dart';

/// This is the stateless widget that the main application instantiates.
class MediaQueryDemo extends StatelessWidget {
  const MediaQueryDemo({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    var width = MediaQuery.of(context).size.width;
    var height = MediaQuery.of(context).size.height;
    return Scaffold(
      appBar: AppBar(title: const Text('MediaQuery Demo')),
      body: Center(
        child: Container(
          height: height * 0.6,
          width: width * 0.6,
          color: Colors.redAccent,
        ),
      ),
    );
  }
}
