package main

import "fmt"

// 单个全局变量
var GlobalVariable = "Hello World"

// 一次性声明多个变量
var (
	def1 = 1
	def2 = "hello"
)

func main() {
	//第一个打印
	/***
	 * 多行注释 | 文档注释
	 */
	hello()
	fmt.Println(GlobalVariable, def1, def2)
	variable()
	primaryType()
	complexType()
}

func hello() {
	fmt.Println("hello world")
}

func variable() {
	var a = 1
	var b = "234"
	var c = 12.2
	var d = 111111111
	e := 123

	// 一次性声明多个变量
	f, g, h := 1, 1, 1

	// 数组

	// 列表

	fmt.Println(a, b, c, d, e, f, g, h)
}

func primaryType() {
	var a1 int = 1    			// 跟随系统-32或者64？
	var a2 int8 = 1				// 1字节
	var a3 int16 = 1			// 2字节
	var a4 int32 = 1			// 4字节
	var a5 int64 = 11111111111	// 8字节

	var (
		b1 uint = 1
		b2 uint8 = 1
		b3 uint16 = 1
		b4 uint32 = 1
		b5 uint64 = 1
		c1 float32 = 3.0000000002			// 会出现精度损失的情况
		c2 float64 = 3.1212121212   // 推荐使用float64（默认）
		d1 byte = 211   // 10进制 【等价于uint8 0~255】
		d2 byte = 011   // 8进制
		d3 byte = 0x11  // 16进制
		d4 byte = 0b11  // 2进制
		d5 byte = 'a'
		e1 bool = true
		e2 bool = false
		e3 = 1 == 0
		e4 = 1 == 1
		f string = "123字符串"
		utf int = '中'
		f2 string = `123字符""""""''''串he咯哦`
	)
	fmt.Println(a1, a2, a3, a4, a5, b1, b2, b3, b4, b5, c1, c2, d1, d2, d3, d4, d5, e1, e2, e3, e4, f, utf, f2)
}

func complexType() {
}