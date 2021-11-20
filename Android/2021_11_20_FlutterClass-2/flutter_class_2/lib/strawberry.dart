import 'package:flutter/material.dart';

class Strawberry extends StatefulWidget {
  const Strawberry({Key? key}) : super(key: key);

  @override
  State<Strawberry> createState() => _StrawberryState();
}

class _StrawberryState extends State<Strawberry> {
  Color lightBlue = const Color.fromARGB(255, 230, 240, 250);

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    return Scaffold(
      appBar: AppBar(
        title: const Text("About"),
      ),
      body: ListView(
        padding: const EdgeInsets.all(10),
        children: [
          Container(
            margin: const EdgeInsets.only(top: 5, bottom: 5),
            child: const Image(
              image: AssetImage('assets/pavlova.png'),
            ),
          ),
          Container(
            margin: const EdgeInsets.only(top: 5, bottom: 5),
            padding: const EdgeInsets.all(10),
            width: double.infinity,
            alignment: Alignment.center,
            decoration: BoxDecoration(
                color: lightBlue,
                border: Border.all(color: Colors.black, width: 2),
                borderRadius: BorderRadius.circular(6)),
            child: const Text(
              "Strawberry Pavlova",
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
          ),
          Container(
            margin: const EdgeInsets.only(top: 5, bottom: 5),
            padding: const EdgeInsets.all(10),
            width: double.infinity,
            alignment: Alignment.center,
            decoration: BoxDecoration(
                color: lightBlue,
                border: Border.all(color: Colors.black, width: 2),
                borderRadius: BorderRadius.circular(6)),
            child: const Text(
              "Pavlova is a meringue-based dessert named after the Russian ballerina Anna Pavlova.\nPavlova features a crisp crust and soft, light inside, usually topped with fruit and whipped cream.",
              textAlign: TextAlign.center,
            ),
          ),
          Container(
            margin: const EdgeInsets.only(top: 5, bottom: 5),
            padding: const EdgeInsets.all(10),
            width: double.infinity,
            alignment: Alignment.center,
            decoration: BoxDecoration(
                color: lightBlue,
                border: Border.all(color: Colors.black, width: 2),
                borderRadius: BorderRadius.circular(6)),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  mainAxisSize: MainAxisSize.min,
                  children: const [
                    Icon(Icons.star),
                    Icon(Icons.star),
                    Icon(Icons.star),
                    Icon(Icons.star_border),
                    Icon(Icons.star_border),
                  ],
                ),
                MaterialButton(
                  onPressed: dummyFunc,
                  child: const Text(
                    "170 reviews",
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                )
              ],
            ),
          ),
          Container(
            margin: const EdgeInsets.only(top: 5, bottom: 5),
            padding: const EdgeInsets.all(10),
            width: double.infinity,
            alignment: Alignment.center,
            decoration: BoxDecoration(
                color: lightBlue,
                border: Border.all(color: Colors.black, width: 2),
                borderRadius: BorderRadius.circular(6)),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Column(
                  children: const [
                    Icon(
                      Icons.kitchen,
                      color: Colors.green,
                    ),
                    Text("PREP:"),
                    Text("25 min"),
                  ],
                ),
                Column(
                  children: const [
                    Icon(
                      Icons.timer,
                      color: Colors.green,
                    ),
                    Text("COOK:"),
                    Text("1 hr"),
                  ],
                ),
                Column(
                  children: const [
                    Icon(
                      Icons.restaurant,
                      color: Colors.green,
                    ),
                    Text("FEEDS:"),
                    Text("4-6"),
                  ],
                )
              ],
            ),
          ),
        ],
      ),
    );
  }

  void dummyFunc() {}
}
