function f = ab3(t0,w0,h,t)
format long
% Using Ralston's method to find w1 and w2:
w1 = w0 + 1/4*h*(func(t0,w0)+3*func(t0+2/3*h, w0 + 2/3*h*func(t0,w0)));
w2 = w1 + 1/4*h*(func(t0+h,w1)+3*func(t0+h+2/3*h, w1 + 2/3*h*func(t0+h,w1)));
% 3rd-order Adams-Bashforth method
while (t0 < t-2*h)
  f = iteration(t0,w0,w1,w2,h);
  w0 = w1;
  w1 = w2;  
  w2 = f;
  t0 = t0+h;
end
f = w2;
end

function w = iteration(t0,w0,w1,w2,h)
t1 = t0+h;
t2 = t0+2*h;
w = w2 + 1/12*h*(23*func(t2,w2)-16*func(t1,w1)+5*func(t0,w0));
end

function f = func(t,y)
f = cos(t) + y - y^3;
% f = exp(-t)-y^2;
% f = (y+t)^2-1;
end