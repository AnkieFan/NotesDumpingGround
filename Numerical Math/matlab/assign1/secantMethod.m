function z = secantMethod(tol,w0,h)
p1 = findStart(w0,h);
p0 = p1-h;
f0 = ab3(0,2,tol,p0);
f1 = ab3(0,2,tol,p1);
z = secantIteration(p0,p1,f0,f1);
  
while (abs(f1) > tol)
  p0 = p1;
  p1 = z;
  f0 = f1;
  f1 = ab3(0,2,tol,p1);
  z = secantIteration(p0,p1,f0,f1);
end
end

function z = secantIteration(p0,p1,f0,f1)
z = p1 - (p1-p0)/(f1-f0)*f1;
end

function s = findStart(w0,h)
t1 = h;
w1 = ab3(0,w0,h,t1);
while((w1<0 && w0<0) || (w1>0 && w0>0))
    w0 = w1;
    t1 = t1+h;
    w1 = ab3(0,w0,h,t1);
end
s = t1;
end