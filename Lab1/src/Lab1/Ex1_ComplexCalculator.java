package Lab1;

import java.util.Scanner;

public class Ex1_ComplexCalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            ComplexNumber num1 = new ComplexNumber(2, 5);
            ComplexNumber num2 = new ComplexNumber(4, -1);
            boolean exit = false;
            do{
            System.out.println("Complex Number 1: " + num1);
            System.out.println("Complex Number 2: " + num2);

                System.out.println("Select operation:");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                ComplexNumber result;
                switch (choice) {
                    case 1:
                        result = num1.add(num2);
                        System.out.println("Result: " + result);
                        System.out.println("----------------------------");
                        break;
                    case 2:
                        result = num1.subtract(num2);
                        System.out.println("Result: " + result);
                        System.out.println("----------------------------");
                        break;
                    case 3:
                        result = num1.multiply(num2);
                        System.out.println("Result: " + result);
                        System.out.println("----------------------------");
                        break;
                    case 4:
                        System.out.println("Exiting the program!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }while(!exit);
        }
    }

    class ComplexNumber {
        private final double real;
        private final double imaginary;

        public ComplexNumber(double real, double imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public ComplexNumber add(ComplexNumber other) {
            double realPart = this.real + other.real;
            double imaginaryPart = this.imaginary + other.imaginary;
            return new ComplexNumber(realPart, imaginaryPart);
        }

        public ComplexNumber subtract(ComplexNumber other) {
            double realPart = this.real - other.real;
            double imaginaryPart = this.imaginary - other.imaginary;
            return new ComplexNumber(realPart, imaginaryPart);
        }

        public ComplexNumber multiply(ComplexNumber other) {
            double realPart = this.real * other.real - this.imaginary * other.imaginary;
            double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
            return new ComplexNumber(realPart, imaginaryPart);
        }

        @Override
        public String toString() {
            if (imaginary >= 0) {
                return real + "+" + imaginary + "i";
            } else {
                return real + "" + imaginary + "i";
            }
        }
    }