defmodule Main do
  def main do
    [n, k, m] = IO.read(:line) |> String.trim() |> String.split(" ") |> Enum.map(&String.to_integer/1)
    table = Enum.reduce(1 .. n, [[1, 0]], fn i, acc ->
      [t1 | _] = acc
      j_max = div(i * (i+1) * k, 2);
      t2 = Enum.map(0 .. j_max, fn j ->
        a1 = max(div((j - div((i - 1) * i * k, 2)) + i - 1, i), 0)
        a2 = min(div(j, i), k)
        rem(Enum.reduce(a1 .. a2, 0, fn a, acc3 ->
          acc3 + Enum.at(t1, j - a * i)
        end), m)
      end)
      [Enum.reverse(t2) | acc]
    end) |> Enum.reverse

    table2 = (1 .. div(n + 1, 2)) |> Enum.map(fn x ->
      [n1, n2] = [x - 1, n - x]
      s = Enum.reduce(0 .. div(n1 * (n1 + 1) * k, 2), 0, fn i, acc ->
        rem((table |> Enum.at(n1) |> Enum.at(i)) * (table |> Enum.at(n2) |> Enum.at(i)) + acc, m)
      end)
      rem(m + s * (k+1) - 1, m)
    end)
    (1 .. n) |> Enum.each(fn x ->
      if x <= div(n + 1, 2) do
        IO.puts(Enum.at(table2, x - 1))
      else
        IO.puts(Enum.at(table2, n - x))
      end
    end)
  end
end
