Groovy method named argument is bit of strange. When calling the method passing named arguments , 
they always captured to the first parameter of the method regardless of where we put them (before or after other parameters passed without name)

    def foo(x,y) {[x,y]}
    assert foo(a:1,b:2,3) == [[a:1, b:2], 3]
    assert foo(3, a:1,b:2) == [[a:1, b:2], 3]
 
