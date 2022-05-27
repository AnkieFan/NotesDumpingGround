function [f,q] = nestedNewton(X,Y)
x = sym('x');
n = length(X);
A = zeros(n,n);
A(:,1) = Y';
for j = 2 : n
    for i = j : n
        A(i,j) = (A(i,j-1) - A(i-1,j-1))/(X(i)-X(i-j+1));
        % A(n,n) is a_n in q(x) = a1 + (x −x1)(a2 + (x −x2)(a3 + ···))
    end
end
f = 0;
for k=n:-1:1
    f= A(k,k) + (x-X(k)) * f % f_k = a_k + (x - x_k) * f_{k+1}
end
% Final formular: f = a1 + (x −x1)(a2 + (x −x2)(a3 + ···))
% ---------------------------------------------------------------

q = 0;
for k=2:n
    i=1;
    for j=2:k-1 % skip (x-x0)
        i=i*(x-X(j));
    end
    q=A(k,k)*i+q; % q_k = a_1+(x-x1)*a_2+(x-x1)(x-x2)*a_3...
end

%A method directly calculate normal polymonial. Quicker but somehow cheating :D
%for k = (n-1):-1:1
%    C = conv(C, poly(X(k)));
%    d = length(C);
%    C(d) = C(d) + A(k,k);
%end
% f = polyval(C,x);
end