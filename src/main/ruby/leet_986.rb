def interval_intersection(a, b)
  a = a.sort
  b = b.sort
  result = []
  while !a.empty? && !b.empty?
    a_head = a.first.first
    a_tail = a.first.last
    b_head = b.first.first
    b_tail = b.first.last
    if b_head > a_tail
      a.shift
    elsif a_head > b_tail
      b.shift
    elsif a_head <= b_head && b_head <= a_tail && a_tail <= b_tail
      result << [b_head, a_tail]
      a.shift
    elsif b_head <= a_head && a_head <= b_tail && b_tail <= a_tail
      result << [a_head, b_tail]
      b.shift
    elsif a_head <= b_head && b_tail <= a_tail
      result << b.first
      b.shift
    elsif b_head <= a_head && a_tail <= b_tail
      result << a.first
      a.shift
    else
      raise a.first, b.first
    end
  end
  result
end

a = [[0, 2], [5, 10], [13, 23], [24, 25]]
b = [[1, 5], [8, 12], [15, 24], [25, 26]]
result = interval_intersection(a, b)
result.each do |each_result|
  puts "#{each_result.first}, #{each_result.last}"
end
