To match a string against regular expression

    def matcher = 'abcd' =~ /abc/
    if (matcher) {
       println 'matched!'
    }

To capture data from matched string

    def pattern = ~/(\S+) and (\S+)/
    matcher = pattern.matcher('hello and world')
    if (matcher) {
       println matcher.group(1) # hello
       println matcher.group(2) # world
    }

The matcher.matches() return true only when pattern matches entire string

    def matcher = 'abcd' =~ /abc/
    println matcher.matches() # false
    
    matcher = 'abcd' =~ /abc.*/
    println matcher.matches() # true
     
