# 数组 #
## 合并两个有序数组 ->先合并数组1,再重新排序
## 移除元素        ->重新计算下标保存
## 删除有序数组中的重复项  ->重新计算下标保存+判断
## 删除有序数组中的重复项 II ->重新计算下标保存+判断
## 多数元素 ->排序,length/2
## 轮转数组 ->利用%和新数组
## 买卖股票的最佳时机 ->Math.max 加 不停更换最小值
## 买卖股票的最佳时机II ->sum请和 加 指针移动
## 跳跃游戏 ->  从每个位置尝试跳一次,更新最大的步数值,当小标>最大的步数值 则false
## 除自身以外数组的乘积 ->新数组填充1,循环i++ j-- 不停求非自身的前n项和 和 后n项和 然后乘机

## 罗马数字转整数 ->switch + map
## 最后一个单词的长度 ->简单
## 最长公共前缀 ->注意是最长前缀不是子串,string的substring的api
## 反转字符串中的单词 ->split后倒序遍历
## 找出字符串中第一个匹配项的下标 ->startIndex不停向下移动
## Z字形变换 ->定义index和operate = 1 或 -1

------------------------------

# hash #
## 两数之和 ->hashmap
## 快乐数 ->递归 -->不是最优解
## 同构字符串 ->map + set (简单的题目做完要检查下,不要因为变量i的问题导致错误) (注意 String s = "badc"; String t = "baba";)
## 单词规律 ->map + set
## 存在重复元素 II ->注意是<=k,需要更换下标
## 赎金信 ->hashmap
## 最长连续序列 ->注意过滤 num-1不存在的,这样就可以找到每个最小的起点了
## 有效的字母异位词 ->hashmap
## 字母异位词分组 ->string转char排序后再转string,然后用map.put排序后的key

------------------------------

# 链表 #
## 环形链表 ->hashset的add的运用 + 循环链表判断
## 合并两个有序链表 ->递归,没做出来,画图才想通一点 ->用了非递归方式实现
## 两数相加 ->看了题解,定义head和tail,tail不停指向下一个,如果其中一个链表是null则加0
## 反转链表II ->使用三个list pre middle last 注意如果left是1 则pre是空 则pre需要帮middle的最后一个元素装进去
## 删除排序链表中的重复元素 ->对指针和改变引用变量不是很清楚
## 删除排序链表中的重复元素II ->记得短链和最后一个节点的处理
## 删除链表的倒数第N个结点 ->没搞出来,看了题解
## 旋转链表 ->用hashmap添加后拼接出来了,但不是最优解
## 分隔链表 ->两个list添加,然后拼接,但不是最优解 ->定义了最小和最大链表解决->定义四个变量(minHead,minTail,maxHead,maxTail)
## LRU 缓存 ->不会做,看了LinkedHashMap的方案,后面还要看下自己用双向链表实现 ->用双链表做了实现

------------------------------

## 双指针 ##
## 验证回文串 ->双指针+正则表达式的运用 s.replaceAll("[^a-zA-Z0-9]", "")
## 判断子序列 ->长字符串不停移动,遇到和短字符串相等的字符,则短字符串的指针往下移动
## 两数之和 -> 无序,用hash
## 两数之和II - 输入有序数组 -> 没做出来,看了题解 我写的是两个指针一个从0开始一个从1 ,题解的是一个从0,一个从最后(很经典) ->注意返回的结果小标是从1开始要加1
## 三数之和 ->数组先排序,for循环第一个数组,然后定义两个指针 用set去重 ->但只击败5.22%的用户
## 盛最多水的容器 ->sum = Math.max(sum, (end - start) * Math.min(v1, v2)); ->又重新做了一遍
## 按奇偶排序数组II ->判断最后一个数,奇数放在奇数位置,原奇数位置的元素放在最后.偶数放在偶数位置,原偶数位置的元素放在最后
## 寻找重复数 -> 快慢指针解法,或排序后判断解法
## 救生艇 ->注意边界问题
## 接雨水 -> 看了左神的视频 ->单个节点结算解法 和 双指针解法
## 供暖器 -> 看了左神的视频 ->排序 然后计算供暖期到房子的距离是不是最优解,如果不是最优解,供暖期下移,是的话房子下移
## 缺失的第一个正数 -> 排序后,通过find =false和 int val 加 find后如果值等于val-1 重复的数字跳过 

------------------------------

## 位运算 ##
## 二进制求和 ->就是进位及下标的处理
## 位1的个数  ->直接看了题解1<<i &n (0<=i<32循环)
## 只出现一次的数字 ->异或运算的引用
## 只出现一次的数字II ->直接用hashmap做了,但不是最优解 -> 看了位运算的解法(很关键)
## 丢失的数字 ->数组排序然后异或判断,需要判断临界条件 ->用位运算实现了
## 只出现一次的数字III ->看了左神的视频讲解
## 颠倒二进制位 ->看了题解,用到了左移和右移
## 二的幂 ->n == (n & -n)  -> n&-n表示提取最右侧的1
## 数字范围按位与 ->  right = right - (right & -right);

------------------------------

## 栈 ##
## 有效的括号 ->注意!stack.isEmpty() 才能弹出pop
## 最小栈 ->直接看了题解,两个Deque解决
## 逆波兰表达式求值 ->直接看了题解,就是进栈遇到运算符再出栈两次,计算后再放入

------------------------------

## 二叉树 ##
## 二叉树的最大深度 ->看了题解,递归 -> 重新做了一遍
## 相同的树 ->看了题解,判断条件不会写,当都为null则true,当只有一个是null则false,当两个val不相等是false,最后只有一种相等的情况则继续递归 ->重新做了一遍
## 二叉树的最小深度 ->递归
## 翻转二叉树 ->递归
## 对称二叉树  ->看了题解 (通过「同步移动」两个指针的方法来遍历这棵树，p 指针和 q 指针一开始都指向这棵树的根)
## 路径总和 ->没做出来,看了题解 递归
## 完全二叉树的节点个数 -> 没做出来,看了题解 递归
## 二叉树的层序遍历 ->递归 map添加
## 二叉树的层平均值 ->递归 map添加,然后再计算
## 从前序与中序遍历序列构造二叉树 ->看了左神的讲解
## 二叉树展开为链表 ->通过list遍历修改root
## 求根节点到叶节点数字之和 ->通过list + 字符串parent
## 填充每个节点的下一个右侧节点指针II ->层序遍历+倒排指向next ->重新看了题解,更加的简单
## 二叉树的右视图 ->层序遍历取最后一个元素的值
## 二叉搜索树的最小绝对差 ->list获取所有节点 排序 然后双指针移动 计算最小值 ->不是最优解
## 二叉搜索树中第K小的元素 ->list获取所有节点 排序 通过k-1下标获取元素 ->不是最优解

------------------------------

## 数学 ##
## 加一 ->list转数组 step / % 和审题注意只加最后一位数
## 回文数 ->两个栈解决
## 三的幂 ->循环判断%3==0 n=n/3 返回判断n==1
## x 的平方根 ->看了题解,使用二分法 ->注意 (long) m * m

------------------------------

## 前缀树 ##
## 实现Trie前缀树 ->看了左神的视频

------------------------------

## 二分查找 ##
## 搜索插入位置 -> 寻找>=target的最左位置,要注意边界问题 如果target > 所有数则返回数组长度
## 寻找峰值 -> 信左神 ->重新做了一遍,好题目
## 搜索二维矩阵 ->分析边界 + 二分查找
## 在排序数组中查找元素的第一个和最后一个位置 ->二分找>=的最左,然后再从最左开始遍历
## 搜索旋转排序数组 ->技巧是和l,r位置的值比较是左边升 还是右边升 然后target值比较,注意边界问题
## 寻找旋转排序数组中的最小值 -> 三种情况 (1):全都升 (2):升中降 (3):升降中 ->调试多次后成功

------------------------------
## 堆 ##
## 合并K个升序链表 ->看了左神的视频,小根堆实现
## 数组中的第K个最大元素 ->用arrays.sort ->大根堆也实现了

------------------------------
## 滑动窗口 ##
## 长度最小的子数组 ->看左神讲解后做的
## 无重复字符的最长子串 ->看左神讲解后做的
## 最小覆盖子串 ->看左神讲解后做的
## 加油站 ->看左神讲解后做的
## 替换子串得到平衡字符串 ->看左神讲解后做的,有点难
## 至少有K个重复字符的最长子串 ->看左神讲解后做的
## K个不同整数的子数组 ->看左神讲解后做的
## --->备注:这块目前还没有思路,里面涉及的思路有点难想


