open Printf

(* Binary tree datatype and auxiliary functions *)

type 'a tree = 
	| Lf
	| Br of 'a * 'a tree * 'a tree

;;

let getval = function 
	| Lf -> 0;
	| Br(v, t1, t2) -> v  

;;

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

(* Binary tree sort approximating the binary insertion sort algorithm *)

let binsearch xs = inord(listtree (xs, Lf), [])

;;

(* Test values below *)

let test = [2;3;5;6;8;7;6;4;2;3;1;10;4;2];;

let output = binsearch test;;

let () = List.iter (printf "%d ") output ;;
