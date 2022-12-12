%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% This file contains the definition of some useful list operations. %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%% 1. Adding an object to a list
% This is just a fact: if we add element X to the list L, the result is a list where X is the head (first element) and L is the tail (remaining elements).
add(X, L, [X | L]).

%%% 2. Deleting an object from a list
% BASE CASE: the result of deleting an element X from a list where X is the head, is a list with all remaining elements (tail).
del(X, [X | Tail], Tail).
% RECURSIVE RULE: the result of deleting an element X from a list with head Y, is a list with the same head Y, but a new tail (Tail1) from which X has been deleted.
del(X, [Y | Tail], [Y | Tail1]) :-
	del(X, Tail, Tail1).

%%% 3. Checking for membership
% BASE CASE: element X is a member of the list where X is the head.
ismember(X, [X | Tail]).
% RECURSIVE RULE: element X is a member of a list if it is a member of the list where the head has been removed.
ismember(X, [Head | Tail]) :-
	ismember(X, Tail).

%%% 4. Concatenation of two lists
% BASE CASE: the concatenation of an empty list with a list L, is the list L itself.
conc([], L, L).
% RECURSIVE RULE: the concatenation of a list with head X and tail L1, and a list L2, is a list with head X and tail obtained by concatenating L1 and L2.
conc([X | L1], L2, [X | L3]) :-
	conc(L1, L2, L3).

%%% 5. Determining sublist of a list
% S is a sublist of L if L is a concatenation of L1, S and L3 (where L1 and L3 are arbitrary sublists, and S is the sublist we are considering)
issublist(S, L) :-
	conc(L1, L2, L),
	conc(S, L3, L2).

%%% 6. Find the common member between 2 lists
% check if the first argument X is a member of both the second argument
% L1 and the third argument L2. If this is the case, then the predicate
% returns true.
common_member(X,L1,L2):-
	ismember(X,L1),
	ismember(X,L2).

%%% 7. Count the number of elements in the list that are greater than
%%% the first argument
% countabove(X, L, N) holds if N is the number of elements in the list L that are greater than X
% BASE CASE: the count of elements greater than X in the empty list is 0
countabove(_,[],0).
% RECURSIVE RULE: if the head of the list H is greater than X, thenthe
% count of elements greater than X in the tail of the list is N1, and
% the result is N1 plus 1. Otherwise the result is the count of elements
% greater than X in the tail of the list.
countabove(X, [H | T], N) :-
	(   H > X
	->  countabove(X, T, N1),
	    N is N1 + 1
	;   countabove(X, T, N)
	).


