# AC

defmodule Main do
  def main do
    [a, b] = IO.read(:line) |> String.trim() |> String.split(" ") |> Enum.map(&String.to_integer/1)
    IO.puts(a * 2 + 100 - b)
  end
end
