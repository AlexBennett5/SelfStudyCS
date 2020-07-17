open Printf

(* DATA TYPES & AUXILIARY FUNCTIONS *)

(* LIST *)

let rec take (ls, n)  = 
        let rec takeaug = function
                | ([], k, acc) -> acc
                | (_, 0, acc) -> acc
                | (x::xs, k, acc) -> takeaug (xs, k-1, x::acc)
        in
                List.rev (takeaug (ls, n, []))
;;

let rec drop = function
        | ([], _) -> []
        | (xs, 0) -> xs
        | (x::xs, k) -> drop (xs, k-1)
;;

(* BINARY TREE *)

type 'a tree = 
	| Lf
	| Br of 'a * 'a tree * 'a tree

;;

(* Get head node values *)

let getval = function 
	| Lf -> 0;
	| Br(v, t1, t2) -> v  

;;

(* Inorder traversal of binary tree *)

let rec inord = function
	| Lf, vs -> vs
	| Br(v, t1, t2), vs -> inord(t1, v::inord(t2, vs))

;;

(* Inserts positive integer v into proper position of binary tree *)

let rec insert = function
	| (Lf, v) -> Br(v, Lf, Lf)
	| (Br(k, t1, t2), v) -> if v < k then Br(k, insert (t1, v), t2)
						else Br(k, t1, insert(t2, v))
;;

(* Converts list to binary tree *)

let rec listtree = function
	| ([], t) -> t 
	| (x::xs, t) -> listtree (xs, insert(t, x))  

;;

(* SORTING ALGORITHMS *)

(* Insertion Sort *)

(* Insert x into proper position of sorted sublist  *)
let rec ins = function
        | (x, []) -> [x]
        | (x, y::ys) -> if x < y then x::y::ys
                        else y::ins(x, ys)
;;

let rec insort = function
        | [] -> []
        | x::xs -> ins(x, insort xs)
;;

(* Binary Tree Sort, approximating the binary insertion sort algorithm in Q7 *)

let binsearch xs = inord(listtree (xs, Lf), [])

;;

(* Selection Sort *)

(* Find value smaller than min *)
let rec selectmin = function
        | ([], min) -> min
        | (x::xs, min) -> if x < min then selectmin (xs, x)
                          else selectmin (xs, min)
;;

(* Remove specified value (for our sake the minimum) from list *)
let rec removemin = function
        | ([], _) -> []
        | (x::xs, min) -> if x = min then xs
                          else x::removemin(xs, min)
;;

let rec selectsort = function
        | [] -> []
        | x::xs -> let min = selectmin(x::xs, x) in
                        min::selectsort(removemin(x::xs, min))
;;

(* Bubble Sort *)

(* One iteration of compare/swap through list *)
let rec bubble = function
        | [] -> []
        | x::[] -> [x]
        | x::y::xs -> if x > y then y::bubble (x::xs)
                      else x::bubble (y::xs)
;;

let rec bsort = function
        | [] -> []
        | xs -> let comp = bubble xs in
                        if comp = bubble comp then comp
                        else bsort comp
;;

(* Merge Sort *)

let rec merge = function
        | (xs, []) -> xs
        | ([], ys) -> ys
        | (x::xs, y::ys) -> if x < y then x::merge (xs, y::ys)
                            else y::merge(x::xs, ys)
;;

let rec mergesort = function
        | [] -> []
        | [x] -> [x]
        | xs -> let k = (List.length xs)/2 in
                let l = mergesort(take (xs, k)) in
                let r = mergesort(drop (xs, k)) in
                        merge(l, r)
;;

(* Quick Sort *)

let rec quicksort = function 
	| [] -> []
        | [x] -> [x]
	| x::xs -> 
		let rec lessthan = function
			| (a, []) -> [] 
			| (a, b::bs) -> if b < a then b::lessthan(a,bs)
						  else lessthan(a,bs)
		in
		let rec morethan = function
			| (a, []) -> []
			| (a, b::bs) -> if b >= a then b::morethan(a,bs)
						 else morethan(a,bs)
		in
                        quicksort (lessthan (x, xs)) @ [x] @ quicksort (morethan (x, xs))

;; 

(* TEST VALUES *)

let test = [2;3;5;6;8;7;6;4;2;3;1;10;4;2];;

let o1 = quicksort test 

let () = List.iter (printf "%d ") o1 ;;
printf "\n";;

