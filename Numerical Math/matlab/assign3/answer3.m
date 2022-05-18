F = cos(2*sym('x'))/(4+3*sin(sym('x')));

figure(1)
hold on
format long

Fun = @(x) subs(F,x);
fplot(Fun,[-pi,pi])

% f is the trigonometric polynomial
% A and B are array of coefficients
% e is error
for i=1:6
    [f,A,B,e] = FourierAppro(F,i)
    if i<4
        fun = @(x) subs(f,x);
        fplot(fun,[-pi,pi])
    end
end    
legend('original','degree1','degree2','degree3')
