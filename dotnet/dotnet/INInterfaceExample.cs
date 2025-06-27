namespace dotnet;

public interface INInterfaceExample
{
    void HelloWorld();
}

public class ImplementationClass: INInterfaceExample
{
    public void HelloWorld()
    {
        System.Console.WriteLine("Hello World");
    }
    
    public static void Main()
    {
        // Declare an interface instance.
        INInterfaceExample obj = new ImplementationClass();

        // Call the member.
        obj.HelloWorld();
    }
    
}

interface IPoint
{
    // Property signatures:
    int X { get; set; }

    int Y { get; set; }

    double Distance { get; }
}

class Point : IPoint
{
    // Constructor:
    public Point(int x, int y)
    {
        X = x;
        Y = y;
    }

    // Property implementation:
    public int X { get; set; }

    public int Y { get; set; }

    // Property implementation
    public double Distance =>
        Math.Sqrt(X * X + Y * Y);
}

class MainClass
{
    static void PrintPoint(IPoint p)
    {
        Console.WriteLine("x={0}, y={1}", p.X, p.Y);
    }

    public static void Main()
    {
        IPoint p = new Point(2, 3);
        Console.Write("My Point: ");
        PrintPoint(p);
    }
}


