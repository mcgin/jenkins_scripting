Hash literal, iteration on a hash

    map = [name:"Gromit", likes:"cheese", id:1234]
    map.each() { key, value -> println "${key} == ${value}" };

Access hash element

    assert map['name'] == "Gromit"
    assert map.name == "Gromit"

Groovy by default convert all keys to a String data type. In order to preserve original type of a key, we must put the key into brace

    def num = 1
    [num: 'hello'].each {k,v -> println k.class} # class java.lang.String
    [(num): 'hello'].each {k,v -> println k.class} # class java.lang.Integer
 
