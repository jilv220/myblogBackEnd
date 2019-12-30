import 'package:flutter/material.dart';

class ChildStateWidget extends StatelessWidget {
  final Color color;

  // constructor of children page
  ChildStateWidget(this.color);


  @override
  Widget build(BuildContext context) {
    return Container(
      color: color,
    );
  }
}