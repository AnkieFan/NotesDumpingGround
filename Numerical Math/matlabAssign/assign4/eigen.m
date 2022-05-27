function [V,D] = eigen(A)
I = diag([1,1,1,1]);
format long
V = zeros(4,4);
D = zeros(4,4);
pre = -1;
cur = 0;
for i=1:4
    x = I(:,i);
    u = (x.')*A*x;
    while(abs(cur-pre) >= (10^-6))
        y = (A-u*I)\x;
        x = y/norm(y,"inf");
        pre = cur;
        cur = x(1,1);
    end
    V(:,i) = x;
    l = A*x;
    D(i,i) = l(i,1);
end
end