% this Prolog code allows you to query a directed acyclic graph to
% determine if two nodes are connected and to find the path between
% them.

% Define the deges of the directed acyclic graph
edge(a,b).
edge(b,d).
edge(c,d).
edge(e,d).
edge(e,g).
edge(g,f).
edge(f,c).
edge(h,g).

% Define the connected/2 predicate
% This predicate is true if there is a directed path from the first to
% the second argument in the directed graph
connected(X,Y):-
    path(X,Y,_).

% Define the path/3 predicate
% The first two arguments represent two nodes and the third argument is
% the path (list of nodes) between them.
path(X,Y,[X,Y]):-
    edge(X,Y).
path(X,Y,[X|Z]):-
    edge(X,Z1), path(Z1,Y,Z).

