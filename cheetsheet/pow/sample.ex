defmodule Main do
  def pow(a, b, m), do: pow(a, b, m, 1)

  def pow(_, 0, _, acc), do: acc

  def pow(a, b, m, acc) do
    if rem(b, 2) == 1 do
      pow(rem(a * a, m), div(b, 2), m, rem(a * acc, m))
    else
      pow(rem(a * a, m), div(b, 2), m, acc)
    end
  end

  #def inverse_fermat(a, b) do

  def main do
    m = 1_000_000_007
    IO.puts(pow(2, 10, m))
    IO.puts(pow(2, 20, m))
    IO.puts(pow(2, 29, m))
    IO.puts(pow(2, 30, m))
  end

end
