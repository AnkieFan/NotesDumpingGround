% 3rd-order Adams-Bashforth method
% when h = 0.1:
w = ab3(0,2,0.1,6)
error = abs(w-(-0.4845092473))
% The error if halve the step size: h = 0.05
w = ab3(0,2,0.05,6)
error = abs(w-(-0.4845092473))

% Secant method for a postive solution
% 3rd parameter 'h' is step size when finding the 
% y(t) crosses 0 between tk and tk+1
% After finding, secant step size will be tol
z = secantMethod(0.001,2,0.5)