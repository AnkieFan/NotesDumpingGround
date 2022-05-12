F = cos(2*sym('x'))/(4+3*sin(sym('x')));

figure(1)
hold on

for i=1:6
    [f,A,B,e] = FourierAppro(F,i)
    if i<4
        fun = @(x) subs(f,x);
        Fun = @(x) subs(F,x);
        fplot(Fun,[0,50*pi])
        fplot(fun,[0,50*pi])
    end
end    