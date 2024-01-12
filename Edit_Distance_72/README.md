edit distance
delete e -> dit (max match)

add s -> dist
add a -> dista
add n -> distan
add c -> distanc
add e -> distance (add left)

total 6 step

   e d k i t
e[ 1 1 _ 1 1 ]
d[ _ 1 0 2 3 ]
k[ _ _ 0 1 2 ]
i[ _ _ _ 1 2 ]
t[ _ _ _ _ 1 ]

{
    e: “e”
    d: “dit”
    k: "_"
    i: “it”
    t: “t”
}

e = 0 ｜ 1 + max(eStr, dkit) = 0｜ 1 + max(dStr, kit)

e = "" 
e = "e" + maxStr(eStr, dkit)

d = max(dStr, kit)  max(k i t, )
k = max(kStr, it)
i = max(iStr, t)
t = "" | "t"



d: “dit”
e dit  
ok di stan ce



e k d _   _ _ _ _   _ _ 

k max(k)

edit okdi stan ce

o k d i    s t a n    c e

 e d k itd




{
    s: {
        maxStr: ""
        word2: ""
        d: {
            maxStr: ""
            word2: ""
            i: {

            },
            t: {

            }
        },
        i: {

        },
        t: {

        },  
    }
}

