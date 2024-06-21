					<div class="form-outline mb-4">
                      <label class="form-label" for="maLoai">Loại giày</label>
                      <select type="text" id="maLoai" name="maLoai" class="form-control form-control-lg" required />
                      <c:forEach var="item" items="${loai1}">
                        <li class="nav-item"> 
                            <a href="capnhatgiayController?maLoai=${item.getMaLoai()}" style="color:black;"
                               class="nav-link <c:if test="${item.getMaLoai().equals(maloai)}" > active </c:if>"
                               aria-current="page">
                                    ${item.getTenLoai()}
                            </a>
                        </li>
                    </c:forEach>
                    </div>
                    
                     <div class="form-outline mb-4">
                      <label class="form-label" for="form2Example17">Loại giày</label>
                      <input type="text" id="form2Example17" name="maLoai" class="form-control form-control-lg" required />
                    </div>
                    <div class="form-outline mb-4">
                      <label class="form-label" for="form2Example17">Hãng giãy</label>
                      <input type="text" id="form2Example17" name="maHang" class="form-control form-control-lg" required />
                    </div>