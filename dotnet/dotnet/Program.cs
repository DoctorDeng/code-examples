namespace dotnet;
using System;

public class Program
{
    public static void Main()
    {
        Console.WriteLine("Hello World!");
        double? pi = 3.14;
        pi = null;
        double a = 1;
        // a = null;
        Console.WriteLine(pi);
        
        dynamic dyn = 1;
        object obj = 1;

        // Rest the mouse pointer over dyn and obj to see their
        // types at compile time.
        System.Console.WriteLine(dyn.GetType());
        System.Console.WriteLine(obj.GetType());
    }
}