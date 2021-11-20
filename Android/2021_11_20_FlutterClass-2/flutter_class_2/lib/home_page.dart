import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_class_2/adaptive/layout_builder_demo.dart';
import 'package:flutter_class_2/adaptive/media_query_demo.dart';
import 'package:flutter_class_2/row_demo.dart';
import 'package:flutter_class_2/strawberry.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: GridView.extent(
        maxCrossAxisExtent: 250,
        padding: const EdgeInsets.all(4),
        mainAxisSpacing: 4,
        crossAxisSpacing: 4,
        children: [
          MaterialButton(
            onPressed: () {
              takeMeTo("Strawberry");
            },
            child: Container(
              child: const Center(
                child: Text("Strawberry"),
              ),
              color: Colors.lightBlue,
            ),
          ),
          MaterialButton(
            onPressed: () {
              takeMeTo("RowDemo");
            },
            child: Container(
              child: const Center(
                child: Text("RowDemo"),
              ),
              color: Colors.lightGreen,
            ),
          ),
          MaterialButton(
            onPressed: () {
              takeMeTo("LayoutBuilderDemo");
            },
            child: Container(
              child: const Center(
                child: Text("LayoutBuilderDemo"),
              ),
              color: Colors.pinkAccent,
            ),
          ),
          MaterialButton(
            onPressed: () {
              takeMeTo("MediaQueryDemo");
            },
            child: Container(
              child: const Center(
                child: Text("MediaQueryDemo"),
              ),
              color: Colors.yellowAccent,
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          ScaffoldMessenger.of(context).showSnackBar(
            const SnackBar(
              content: Text("How you doin'?"),
            ),
          );
        },
        tooltip: 'Increment',
        child: const Icon(Icons.home),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }

  takeMeTo(var name) {
    switch (name) {
      case "Strawberry":
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => const Strawberry(),
          ),
        );
        break;
      case "RowDemo":
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => const RowDemo(),
          ),
        );
        break;
      case "LayoutBuilderDemo":
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => const LayoutBuilderDemo(),
          ),
        );
        break;
      case "MediaQueryDemo":
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => const MediaQueryDemo(),
          ),
        );
        break;
    }
  }
}
