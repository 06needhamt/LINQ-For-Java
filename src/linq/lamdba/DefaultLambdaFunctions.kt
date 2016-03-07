/*
The MIT License (MIT)

Copyright (c) 2016 Tom Needham

Permission is hereby granted, free of charge, to any person obtaining a
copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be included
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package linq.lamdba

import linq.lamdba.exceptions.DivisionByZeroException

/**
 * Created by Tom Needham on 03/03/2016.
 */
open class DefaultLambdaFunctions {
   companion object Functors {
        @JvmStatic()
        fun Test(i: Int) : Boolean {
            return i == 10
        }
       @JvmStatic()
       fun InRange(a: Int, b: Int) : Boolean{
           return a <= b
       }
       @JvmStatic()
       fun LessThan(a: Int, b: Int) : Boolean{
           return a < b
       }
       @JvmStatic()
       fun MoreThan(a: Int, b: Int) : Boolean{
           return a > b
       }
       @JvmStatic()
       fun LessThanOrEqual(a: Int, b: Int) : Boolean{
           return a <= b
       }
       @JvmStatic()
       fun MoreThanOrEqual(a: Int, b: Int) : Boolean{
           return a >= b
       }
       @JvmStatic()
       fun Equal(a: Int, b: Int) : Boolean{
           return a == b
       }
       @JvmStatic()
       fun NotEqual(a: Int, b: Int) : Boolean{
           return a != b
       }
       @JvmStatic()
       fun LeftShift(a: Int, b: Int) : Int{
           return a.shl(b)
       }
       @JvmStatic()
       fun SignedRightShift(a: Int, b: Int) : Int{
           return a.shr(b)
       }
       @JvmStatic()
       fun UnsignedShiftRight(a: Int, b: Int) : Int{
           return a.ushr(b)
       }
       @JvmStatic()
       fun Add(a: Int, b: Int) : Int{
           return a + b
       }
       @JvmStatic()
       fun Subtract(a: Int, b: Int) : Int{
           return a - b
       }
       @JvmStatic()
       fun Multiply(a: Int, b: Int) : Int{
           return a * b
       }
       @JvmStatic()
       fun Divide(a: Int, b: Int) : Int{
           if(b == 0)
               throw DivisionByZeroException();
           return a / b
       }
       @JvmStatic()
       fun And(a: Int, b: Int) : Int{
           return a.and(b)
       }
       @JvmStatic()
       fun Or(a: Int, b: Int) : Int{
           return a.or(b)
       }
       @JvmStatic()
       fun Mod(a: Int, b: Int) : Int{
           return a.mod(b)
       }
       @JvmStatic()
       fun Xor(a: Int, b: Int) : Int{
           return a.xor(b)
       }
       @JvmStatic()
       fun Pow(a: Int, b: Int) : Int{
           return Math.pow(a.toDouble(),b.toDouble()).toInt()
       }

       @JvmStatic()
       fun InRange(a: Short, b: Short) : Boolean{
           return a <= b
       }
       @JvmStatic()
       fun LessThan(a: Short, b: Short) : Boolean{
           return a < b
       }
       @JvmStatic()
       fun MoreThan(a: Short, b: Short) : Boolean{
           return a > b
       }
       @JvmStatic()
       fun LessThanOrEqual(a: Short, b: Short) : Boolean{
           return a <= b
       }
       @JvmStatic()
       fun MoreThanOrEqual(a: Short, b: Short) : Boolean{
           return a >= b
       }
       @JvmStatic()
       fun Equal(a: Short, b: Short) : Boolean{
           return a == b
       }
       @JvmStatic()
       fun NotEqual(a: Short, b: Short) : Boolean{
           return a != b
       }
       @JvmStatic()
       fun Add(a: Short, b: Short) : Short{
           return (a + b).toShort()
       }
       @JvmStatic()
       fun Subtract(a: Short, b: Short) : Short{
           return (a - b).toShort()
       }
       @JvmStatic()
       fun Multiply(a: Short, b: Short) : Short{
           return (a * b).toShort()
       }
       @JvmStatic()
       fun Divide(a: Short, b: Short) : Short{
           if((b == 0.toShort()))
               throw DivisionByZeroException();
           return (a / b).toShort()
       }
       @JvmStatic()
       fun Mod(a: Short, b: Short) : Short{
           return (a.mod(b)).toShort()
       }
       @JvmStatic()
       fun Pow(a: Short, b: Short) : Short{
           return Math.pow(a.toDouble(),b.toDouble()).toShort()
       }

       @JvmStatic()
       fun InRange(a: Long, b: Long) : Boolean{
           return a <= b
       }
       @JvmStatic()
       fun LessThan(a: Long, b: Long) : Boolean{
           return a < b
       }
       @JvmStatic()
       fun MoreThan(a: Long, b: Long) : Boolean{
           return a > b
       }
       @JvmStatic()
       fun LessThanOrEqual(a: Long, b: Long) : Boolean{
           return a <= b
       }
       @JvmStatic()
       fun MoreThanOrEqual(a: Long, b: Long) : Boolean{
           return a >= b
       }
       @JvmStatic()
       fun Equal(a: Long, b: Long) : Boolean{
           return a == b
       }
       @JvmStatic()
       fun NotEqual(a: Long, b: Long) : Boolean{
           return a != b
       }
       @JvmStatic()
       fun LeftShift(a: Long, b: Long) : Long{
           return a.shl(b.toInt())
       }
       @JvmStatic()
       fun SignedRightShift(a: Long, b: Long) : Long{
           return a.shr(b.toInt())
       }
       @JvmStatic()
       fun UnsignedShiftRight(a: Long, b: Long) : Long{
           return a.ushr(b.toInt())
       }
       @JvmStatic()
       fun Add(a: Long, b: Long) : Long{
           return a + b
       }
       @JvmStatic()
       fun Subtract(a: Long, b: Long) : Long{
           return a - b
       }
       @JvmStatic()
       fun Multiply(a: Long, b: Long) : Long{
           return a * b
       }
       @JvmStatic()
       fun Divide(a: Long, b: Long) : Long{
           if(b == 0L)
               throw DivisionByZeroException();
           return a / b
       }
       @JvmStatic()
       fun And(a: Long, b: Long) : Long{
           return a.and(b)
       }
       @JvmStatic()
       fun Or(a: Long, b: Long) : Long{
           return a.or(b)
       }
       @JvmStatic()
       fun Mod(a: Long, b: Long) : Long{
           return a.mod(b)
       }
       @JvmStatic()
       fun Xor(a: Long, b: Long) : Long{
           return a.xor(b)
       }
       @JvmStatic()
       fun Pow(a: Long, b: Long) : Long{
           return Math.pow(a.toDouble(),b.toDouble()).toLong()
       }

       @JvmStatic()
       fun InRange(a: Float, b: Float) : Boolean{
           return a <= b
       }
       @JvmStatic()
       fun LessThan(a: Float, b: Float) : Boolean{
           return a < b
       }
       @JvmStatic()
       fun MoreThan(a: Float, b: Float) : Boolean{
           return a > b
       }
       @JvmStatic()
       fun LessThanOrEqual(a: Float, b: Float) : Boolean{
           return a <= b
       }
       @JvmStatic()
       fun MoreThanOrEqual(a: Float, b: Float) : Boolean{
           return a >= b
       }
       @JvmStatic()
       fun Equal(a: Float, b: Float) : Boolean{
           return a == b
       }
       @JvmStatic()
       fun NotEqual(a: Float, b: Float) : Boolean{
           return a != b
       }
       @JvmStatic()
       fun Add(a: Float, b: Float) : Float{
           return a + b
       }
       @JvmStatic()
       fun Subtract(a: Float, b: Float) : Float{
           return a - b
       }
       @JvmStatic()
       fun Multiply(a: Float, b: Float) : Float{
           return a * b
       }
       @JvmStatic()
       fun Divide(a: Float, b: Float) : Float{
           if(b == 0.0f)
               throw DivisionByZeroException();
           return a / b
       }
       @JvmStatic()
       fun Mod(a: Float, b: Float) : Float{
           return a.mod(b)
       }
       @JvmStatic()
       fun Pow(a: Float, b: Float) : Float{
           return Math.pow(a.toDouble(),b.toDouble()).toFloat()
       }
       @JvmStatic()
       fun InRange(a: Double, b: Double) : Boolean{
           return a <= b
       }
       @JvmStatic()
       fun LessThan(a: Double, b: Double) : Boolean{
           return a < b
       }
       @JvmStatic()
       fun MoreThan(a: Double, b: Double) : Boolean{
           return a > b
       }
       @JvmStatic()
       fun LessThanOrEqual(a: Double, b: Double) : Boolean{
           return a <= b
       }
       @JvmStatic()
       fun MoreThanOrEqual(a: Double, b: Double) : Boolean{
           return a >= b
       }
       @JvmStatic()
       fun Equal(a: Double, b: Double) : Boolean{
           return a == b
       }
       @JvmStatic()
       fun NotEqual(a: Double, b: Double) : Boolean{
           return a != b
       }
       @JvmStatic()
       fun Add(a: Double, b: Double) : Double{
           return a + b
       }
       @JvmStatic()
       fun Subtract(a: Double, b: Double) : Double{
           return a - b
       }
       @JvmStatic()
       fun Multiply(a: Double, b: Double) : Double{
           return a * b
       }
       @JvmStatic()
       fun Divide(a: Double, b: Double) : Double{
           if(b == 0.0)
               throw DivisionByZeroException();
           return a / b
       }
       @JvmStatic()
       fun Mod(a: Double, b: Double) : Double{
           return a.mod(b)
       }

       @JvmStatic()
       fun Pow(a: Double, b: Double) : Double{
           return Math.pow(a,b)
       }
       
    }
}
