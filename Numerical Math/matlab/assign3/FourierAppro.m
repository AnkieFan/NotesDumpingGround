function [f,A,B,e] = FourierAppro(F,k)
A = zeros(1,k+1);
B = zeros(1,k);
A(1) = double(1/pi*int(F*cos(0*sym('x')),[-pi,pi]));
f = A(1)/2;
e = 0;
for i = 1:k
   A(i+1) = 1/pi*int(F*cos(i*sym('x')),[-pi,pi]);
   f = f + A(i+1)*cos(i*sym('x'));
   B(i) = 1/pi*int(F*sin(i*sym('x')),[-pi,pi]);
   f = f + B(i)*sin(i*sym('x'));
   e = e + (A(i+1)^2+B(i)^2);
end
e = e*pi;
end