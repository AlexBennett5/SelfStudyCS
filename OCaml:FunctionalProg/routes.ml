let rec startpoints (xs, z) = 
	let rec startpointsaug = function
		| ([], z, accum) -> accum 
		| ((x,y)::xs, z, accum) -> if y=z then startpointsaug (xs, z, x::accum)
						   else startpointsaug (xs, z, accum)
	in
		startpointsaug (xs, z, []);; 

let rec endpoints (xs, z) = 
	let rec endpointsaug = function
		| ([], z, accum) -> accum 
		| ((x,y)::pairs, z, accum) -> if x=z then endpointsaug (pairs, z, y::accum)
					      else endpointsaug (pairs, z, accum)
	in
		endpointsaug (xs, z, []);;


let rec allpairs = function
	| ([], _) -> [] 
 	| (_, []) -> []
	| (b::bs, y::ys) ->   
		let rec leftpairs = function
			| ([], k, accum) -> accum 
			| (x::xs, k, accum) -> leftpairs (xs, k, (x,k)::accum)
		in
	  		leftpairs (b::bs, y, []) @ allpairs(b::bs, ys)


let addnew((a,b), pairs) = allpairs(startpoints(pairs, a), [b]) @ allpairs([a], endpoints(pairs, b)) @ (a,b)::pairs


let rec routes = function
	| [] -> [] 
	| (x,y)::xs -> addnew((x,y), routes(xs))

