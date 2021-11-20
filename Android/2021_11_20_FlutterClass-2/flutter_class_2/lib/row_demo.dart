import 'package:flutter/material.dart';

class RowDemo extends StatefulWidget {
  const RowDemo({Key? key}) : super(key: key);

  @override
  State<RowDemo> createState() => _RowDemoState();
}

class _RowDemoState extends State<RowDemo> {
  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    return Scaffold(
      appBar: AppBar(
        title: const Text("Row demo"),
      ),
      body: Container(
        padding: const EdgeInsets.only(top: 10, bottom: 10),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            Column(
              children: const [
                Icon(
                  Icons.call,
                  color: Colors.blue,
                ),
                Text(
                  "Call",
                  style: TextStyle(color: Colors.blue),
                )
              ],
            ),
            Column(
              children: const [
                Icon(Icons.directions, color: Colors.blue),
                Text(
                  "Route",
                  style: TextStyle(color: Colors.blue),
                )
              ],
            ),
            Column(
              children: const [
                Icon(Icons.share, color: Colors.blue),
                Text(
                  "Share",
                  style: TextStyle(color: Colors.blue),
                )
              ],
            ),
          ],
        ),

        /*
      With more paddings and clickable
      */

        // body: Padding(
        //   padding: const EdgeInsets.only(top: 10, bottom: 10),
        //   child: Wrap(
        //     children: [
        //       Row(
        //         mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        //         children: [
        //           InkWell(
        //             onTap: dummyFunc,
        //             child: Column(
        //               children: const [
        //                 Icon(
        //                   Icons.call,
        //                   color: Colors.blue,
        //                 ),
        //                 Text(
        //                   "Call",
        //                   style: TextStyle(color: Colors.blue),
        //                 )
        //               ],
        //             ),
        //           ),
        //           InkWell(
        //             onTap: dummyFunc,
        //             child: Column(
        //               children: const [
        //                 Icon(Icons.directions, color: Colors.blue),
        //                 Text(
        //                   "Route",
        //                   style: TextStyle(color: Colors.blue),
        //                 )
        //               ],
        //             ),
        //           ),
        //           InkWell(
        //             onTap: dummyFunc,
        //             child: Column(
        //               children: const [
        //                 Icon(Icons.share, color: Colors.blue),
        //                 Text(
        //                   "Share",
        //                   style: TextStyle(color: Colors.blue),
        //                 )
        //               ],
        //             ),
        //           ),
        //         ],
        //       ),
        //     ],
        //   ),
        // ),
      ),
    );
  }

  void dummyFunc() {}
}
