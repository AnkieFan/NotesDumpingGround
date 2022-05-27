X =[2.5 2.0 3.0 1.5 3.5 1.0 4.0 0.5 4.5 0.0 5.0];
Y = [0.06 0.19 0.00 0.43 0.01 0.77 0.07 1.25 0.14 2.00 0.21];
a = -0.1:0.01:5.1;
[f, q] = nestedNewton(X, Y);
f = subs(f,a)
q % the derivative
disp(vpa(subs(q,2.5),8)) % the derivative at x0 = 2.5

figure(1)
plot(X,Y,'g+',a,f,'m')
grid on
hold on

Y = [0.09 0.13 0.00 0.41 0.12 0.69 0.02 1.26 0.19 2.09 0.13];
[f, q] = nestedNewton(X, Y);
f = subs(f,a)
plot(X,Y,'r+',a,f,'c')
legend('samples','interpolants','Samples with noise','interpolants with noise')
q % the derivative
disp(vpa(subs(q,2.5),8)) % the derivative at x0 = 2.5


% Overfitting: interpolation will go through all the sample point.
% So it can not ignore errors, which leads to overfitting.
% Spline may be better.