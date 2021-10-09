# 

defmodule Main do
  #def pow(a, b, m), do: pow(a, b, m, 1)
  #def pow(_, 0, _, acc), do: acc
  #def pow(a, b, m, acc) do
  #  if rem(b, 2) == 1 do
  #    pow(rem(a * a, m), div(b, 2), m, rem(a * acc, m))
  #  else
  #    pow(rem(a * a, m), div(b, 2), m, acc)
  #  end
  #end

  def main do
    a = IO.read(:line) |> String.trim() |> String.to_integer
    [b, c] = IO.read(:line) |> String.trim() |> String.split(" ") |> Enum.map(&String.to_integer/1)
    [t1, t2] = IO.read(:line) |> String.trim() |> String.split(" ")
    s2 = IO.read(:line) |> String.trim()
    IO.puts(a + b + c)
    IO.puts(t1 <> t2)
    IO.puts(s2)
  end
end
