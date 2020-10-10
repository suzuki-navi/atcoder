# AC

defmodule Main do
  @divisor 1_000_000_007

  def main do
    IO.read(:line)
    |> String.trim()
    |> String.to_integer()
    |> solve()
    |> IO.puts()
  end

  def solve(n) do
    rem(2 * @divisor + pow(10, n) - 2 * pow(9, n) + pow(8, n), @divisor)
  end

  def pow(m, n), do: pow(m, n, 1)

  def pow(_, 0, acc), do: acc

  def pow(m, n, acc) do
    if Kernel.rem(n, 2) == 1 do
      pow(Kernel.rem(m * m, @divisor), Kernel.div(n, 2), Kernel.rem(m * acc, @divisor))
    else
      pow(Kernel.rem(m * m, @divisor), Kernel.div(n, 2), acc)
    end
  end
end
