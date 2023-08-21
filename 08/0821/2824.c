// A B 최대 공약수
// 엄청 큰 수를 어떻게 처리할것인가

// long으로 받고 만약 9자리가 넘어가면 그때는 뒤만 출력!
// 최대 공약수 구하는 법 
// a,b ->  

#include <math.h>
#include <stdio.h>
#include <stdlib.h>

int f_strlen(unsigned long long n)
{
    int cnt = 0;
    while (n > 0)
    {
        cnt++;
        n /= 10;
    }
    return cnt;
}

unsigned long long gcd(unsigned long long a, unsigned long long b)
{
    unsigned long long temp;

    while (b != 0)
    {
        temp = b % a;
        b = a;
        a = temp;
    }
    return a;
}
void check(unsigned long long n)
{
    // n이 9자리가 넘어가는지 확인하자!
    int cnt = f_strlen(n);
    int sub;

    if (cnt > 9)
    {
        sub = n % 1000000000;
        cnt = f_strlen(sub);
        for (int i =9; i> 0; i--)
        {
            // 0000 12028
            if (i > cnt)
                printf("%d", 0);
            else
            {
                break;   
            }
        }
        printf("%d\n",sub);
    }
    else
    {
        printf("%lld\n", n);
    }
}

int main(void)
{
    unsigned long long A = 1;
    unsigned long long B = 1;
    unsigned long long result;

    int n,m,s;
    scanf("%d",&n);
    for(int i =0; i< n; i++)
    {
        scanf("%d",&s);
        A *= s;
    }
    scanf("%d",&m);
    for(int i =0; i< m; i++)
    {
        scanf("%d",&s);
        B *= s;
    }

    if (A > B)
    {
        result = gcd(B,A);
    }
    else
        result = gcd(A,B);
    check(result);
    return (0);
}