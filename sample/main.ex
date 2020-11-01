# 

defmodule Main do
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
