# AC

defmodule Main do
  def main do
    n = IO.read(:line) |> String.trim() |> String.to_integer
    if rem(n, 2) == 0 do
      IO.puts("White")
    else
      IO.puts("Black")
    end
  end
end
