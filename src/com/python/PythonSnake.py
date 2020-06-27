
#PythonDraw.py

import turtle as t
# 四参数 窗体X轴长度 Y轴长度 距离左上角宽和高 后两个参数缺失时候窗体显示在中间
t.setup(650,350,200,200)
# 画笔抬起
t.penup()

t.fd(-250)
#
t.pendown()
# 画笔尺寸 宽度
t.pensize(25)
# 颜色 或者 R,G,B
t.pencolor("purple")
t.pencolor(0.63, 0.13, 0.94)
t.pencolor((0.63, 0.13, 0.94))

# 使用小数值
# t.colormode()
t.seth(-40)

for i in range(4):
    t.circle(40,80)
    t.circle(-40,80)

t.circle(40, 80/2)

t.fd(40)

t. circle(16, 180)

t. fd(40 *2/3)

# 程序运行之后 窗体不退出
t.done()

# 让海龟去这个坐标点
# t.goto(100,100)

# 海归向前
# t.fd(d)

# 海归向后
# t.bk(d)

# 海归饶左侧点花园
# t.circle(r,angle)

# 只改变海归行进方向 不行进 angle是绝对度数
# t.seth(angle)
# 相对角度 向左向右转方向
# t.left(angle)
# t.right(angle)

# 海归飞起 画笔抬起 别名 pu
# t.penup

# t.circle(r,angle)




