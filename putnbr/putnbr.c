#include <unistd.h>

void	ft_putchar(char c)
{
	write(1, &c, 1);
}

void	ft_putnbr(int nb)
{
	if (nb == -2147483648)
	{
		ft_putnbr(nb / 10);
		ft_putchar('8'); // 맨 마지막이 이게 나와야함!
	}
	else if (nb < 0)
	{
		ft_putchar('-');
        // 음수로 적어주고 바로 다시 양수들 출력해주기!
        // 10이상의 단어를 한번에 
		ft_putnbr(-nb);
	}
	else
	{
        // 10보다 크다 -> 단어 한개씩 나오게 만들기!
        // 재귀로 들어가네!
		if (nb > 9)
		{
			ft_putnbr(nb / 10);
		}
		ft_putchar(48 + nb % 10);
	}
}

int		main(void)
{
	ft_putnbr(42);
	ft_putchar('\n');
	ft_putnbr(4242);
	ft_putchar('\n');
    ft_putnbr(-4343);
    ft_putchar('\n');
	ft_putnbr(20000706);
	ft_putchar('\n');
	ft_putnbr(+2147483647);
	ft_putchar('\n');
	ft_putnbr(-2147483648);
}